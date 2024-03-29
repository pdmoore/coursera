package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
        allDrivers.minus(
                trips.map { it -> it.driver }
                        .toSet())


/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
        allPassengers.filter { it ->
            trips.filter { trip: Trip -> it in trip.passengers }
                    .count() >= minTrips
        }.toSet()


/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
        allPassengers.filter { it ->
            trips.filter { trip: Trip ->
                it in trip.passengers && driver == trip.driver }
                    .count() > 1
        }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
        allPassengers.filter { it ->
            val tripsWithDiscount = trips.count { trip: Trip -> it in trip.passengers && trip.discount != null }
            val tripsWithoutDiscount = trips.count { trip: Trip -> it in trip.passengers && trip.discount == null }

            tripsWithDiscount > tripsWithoutDiscount
        }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {

    val timeSlotWithMostTrips = trips.groupingBy { it ->
        it.duration.div(10) }
            .eachCount().maxBy { it -> it.value }?.key ?: return null

    val timeSlotTens = timeSlotWithMostTrips.times(10);
    return IntRange(timeSlotTens, timeSlotTens.plus(9) )
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false

    val allTripsIncome = trips.sumByDouble { it.cost }

    // get the income by each driver, sorted from greatest to smallest
    val sortedDriversIncome: List<Double> = trips
            .groupBy { it.driver }
            .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble { it.cost } }
            .sortedDescending()

    // tally income of top 20% of drivers
    val numDriversToCheck = allDrivers.size.times(.2).toInt()
    val sumOfTopDrivers = sortedDriversIncome
            .take(numDriversToCheck)
            .sum()

    return (sumOfTopDrivers >= allTripsIncome.times(.8))
}