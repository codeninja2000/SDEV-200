package com.m06.p01_staffrecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * StaffDao is a data access object (DAO) class that provides methods
 * for interacting with Staff entities in the database. It implements
 * the generic Dao interface for basic CRUD operations.
 */
public class StaffDao implements Dao<Staff> {
    /**
     * This variable is initialized through the constructor of the StaffDao class
     * and remains immutable throughout the lifecycle of the instance.
     */
    private final DbConnection dbConnection;

    public StaffDao(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * Executes an SQL statement to insert or update a Staff record in the database.
     * The method sets the parameters of the prepared statement based on the fields
     * of the provided Staff object and executes the SQL query.
     *
     * @param staff        the Staff object containing the data to be inserted or updated
     * @param sql          the SQL query to insert or update the Staff record
     * @param dbConnection the database connection utility to manage the connection
     * @throws SQLException if a database access error occurs
     */
    private static void put(Staff staff, String sql, DbConnection dbConnection) throws SQLException {
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, staff.getId());
            pstmt.setString(2, staff.getLastName());
            pstmt.setString(3, staff.getFirstName());
            pstmt.setString(4, staff.getMi());
            pstmt.setString(5, staff.getAddress());
            pstmt.setString(6, staff.getCity());
            pstmt.setString(7, staff.getState());
            pstmt.setString(8, staff.getTelephone());
            pstmt.setString(9, staff.getEmail());

            pstmt.executeUpdate();
        }
    }

    /**
     * Inserts a new Staff record into the database using the provided Staff object.
     *
     * @param staff the Staff object containing the data to be inserted into the database
     * @throws SQLException if an SQL error occurs during the insert operation
     */

    /**
     * Retrieves a Staff object by its ID from the database.
     * If the Staff is found, it is wrapped in an Optional.
     * If no Staff with the given ID exists or an exception occurs, an empty Optional is returned.
     *
     * @param id the unique identifier of the Staff to be retrieved
     * @return an Optional containing the Staff object if found, or an empty Optional if not found
     */
    @Override
    public Optional<Staff> viewById(String id) {
        try {
            Staff staff = findById(id);
            return Optional.ofNullable(staff);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Inserts a new Staff record into the database.
     *
     * @param staff the Staff object containing the data to be inserted
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void insert(Staff staff) throws SQLException {
        String sql = "INSERT INTO staff (id, lastName, firstName, mi, address, city, state, telephone, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        put(staff, sql, dbConnection);
    }

    /**
     * Retrieves a Staff object from the database based on the given ID.
     * If a staff member with the specified ID exists, it is returned.
     * If no matching staff member is found, the method returns null.
     *
     * @param id the unique identifier of the staff member to retrieve
     * @return the Staff object corresponding to the given ID, or null if no match is found
     * @throws SQLException if an error occurs while accessing the database
     */
    public Staff findById(String id) throws SQLException {
        String sql = "SELECT * FROM staff WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToStaff(rs);
                }
            }
        }
        return null;
    }

    /**
     * Updates the details of an existing staff member in the database.
     * The provided staff object contains the updated information for a staff member
     * with the given ID.
     *
     * @param staff the Staff object containing the updated details
     * @throws SQLException if a database access error occurs
     */
    public void update(Staff staff) throws SQLException {
        String sql = "UPDATE staff SET lastName=?, firstName=?, mi=?, address=?, " +
                "city=?, state=?, telephone=?, email=? WHERE id=?";

        put(staff, sql, dbConnection);
    }

    /**
     * Deletes a staff record from the database based on the provided ID.
     *
     * @param id the unique identifier of the staff member to be deleted
     * @throws SQLException if a database access error occurs
     */
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM staff WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }

    /**
     * Maps a ResultSet object to a Staff object. Extracts data from the ResultSet
     * and sets the corresponding fields in the Staff object.
     *
     * @param rs the ResultSet containing the staff data retrieved from the database
     * @return a Staff object populated with data from the ResultSet
     * @throws SQLException if a database access error occurs or the ResultSet is invalid
     */
    private Staff mapResultSetToStaff(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        staff.setId(rs.getString("id"));
        staff.setLastName(rs.getString("lastName"));
        staff.setFirstName(rs.getString("firstName"));
        staff.setMi(rs.getString("mi"));
        staff.setAddress(rs.getString("address"));
        staff.setCity(rs.getString("city"));
        staff.setState(rs.getString("state"));
        staff.setTelephone(rs.getString("telephone"));
        staff.setEmail(rs.getString("email"));
        return staff;
    }
}