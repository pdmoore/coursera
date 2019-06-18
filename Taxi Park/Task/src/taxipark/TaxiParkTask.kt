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

    val tripsByTens = trips.groupingBy { it -> it.duration.div(10) }.eachCount()
    println(tripsByTens)
    val maximum = tripsByTens.maxBy { it -> it.value }

    if (null == maximum) return null

    println(maximum?.key)
    val maxKey = maximum!!.key.times(10);
    val mostFrequent = IntRange(maxKey, maxKey.plus(9) )

    return mostFrequent
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    TODO()
}