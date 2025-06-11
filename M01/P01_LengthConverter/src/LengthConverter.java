public class LengthConverter {

    // Conversion constant for meter-to-foot conversions
    private static final double FEET_PER_METER = 3.279;

    // Conversion constant for foot-to-meter conversions
    private static final double METER_PER_FOOT = 0.305;

    // Function to convert foot to meter
    // Precondition: foot >= 0
    // Postcondition: if the precondition is not met, -1 is returned
    // otherwise the converted quantity is returned
    public static double footToMeter(double foot) {
        if (foot < 0)
            return -1;
        return METER_PER_FOOT * foot;
    }

    // Function to convert meter to foot
    // Precondition: meter >= 0
    // Postcondition: if the precondition is not met, -1 is returned
    // otherwise the converted quantity is returned
    public static double meterToFoot(double meter) {
        if (meter < 0)
            return -1;
        return FEET_PER_METER * meter;
    }

}
