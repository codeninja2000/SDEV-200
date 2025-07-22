package com.m06.p01_staffrecord;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Dao is a generic interface for Data Access Objects (DAO).
 * It defines methods for basic CRUD operations.
 *
 * @param <T> the type of the entity that the DAO will manage
 */
public interface Dao<T> {
    /**
     * Retrieves an entity by its ID.
     *
     * @param id the ID of the entity
     * @return an Optional containing the entity if found, or empty if not found
     */
    Optional<T> viewById(String id);
    /**
     * Inserts a new entity into the database.
     *
     * @param record the entity to insert
     * @throws SQLException if an SQL error occurs
     */
    void insert(T record) throws SQLException;
    /**
     * Updates an existing entity in the database.
     *
     * @param record the entity to update
     * @throws SQLException if an SQL error occurs
     */
    void update(T record) throws SQLException;

}
