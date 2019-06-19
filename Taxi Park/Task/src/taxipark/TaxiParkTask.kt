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
            trips.filter { trip: Trip -> it in trip.passengers && trip.discount != null }.count() >   // trips with discount
            trips.filter { trip: Trip -> it in trip.passengers && trip.discount == null }.count()     // trips without discount

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
    if (trips.size == 0) return false

    val allTripsCost = trips.sumByDouble { it.cost }

    // for each driver
    // for each trip
    // if driver == trip.driver, then add to runningIncome
    // result is map of driver to income
    var incomeByDriver = HashMap<Driver, Double>()
    for (driver in allDrivers) {
        var runningSum: Double = 0.0

        for (trip in trips) {
            if (trip.driver == driver) {
                runningSum = runningSum.plus(trip.cost)
            }
        }

        incomeByDriver.put(driver, runningSum)
    }

    // did a single driver exceed 80%?
    val eightPercentOfAllIncome = allTripsCost.times(.8)
    for (driverIncome in incomeByDriver.values) {
        if (driverIncome >= eightPercentOfAllIncome) return true
    }

    // check if 20% of drivers exceed 80% of all trips
    val numDriversToCheck = allDrivers.size.times(.2).toInt()

    // find sum of income by numDriversToCheck
    val result = incomeByDriver.toList().sortedByDescending { (_, value) -> value}.toList()

    var sumOfTopDrivers: Double = 0.0
    for (i in 0 until numDriversToCheck) {
        sumOfTopDrivers = sumOfTopDrivers.plus(result[i].second)
    }

    if (sumOfTopDrivers >= eightPercentOfAllIncome) return true

    return false
}