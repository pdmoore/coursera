package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
        allDrivers.minus(this.trips.map { it.driver }.toSet())


/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    if (minTrips == 0) return allPassengers

    // allPassengers
    // each trip can have 1 or more passengers
    // count each time a passenger is seen in a trip
    // filter by those counts against minTrips
    val passengerTripCounts:HashMap<Passenger, Int?> = HashMap()
    for (trip in trips) {
        for (passenger in trip.passengers) {
            if (passengerTripCounts.containsKey(passenger)) {
                var currentCount = passengerTripCounts.get(passenger)
                passengerTripCounts.replace(passenger, currentCount?.plus(1))
            } else {
                passengerTripCounts.put(passenger, 1)
            }
        }
    }

    val qualifyingPassengers:HashSet<Passenger> = HashSet()
    for (key in passengerTripCounts.keys) {
        val tripCount = passengerTripCounts?.get(key) ?: 0
        if (tripCount >= minTrips) qualifyingPassengers.add(key)
    }


    return qualifyingPassengers.toSet()
}

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
        TODO()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
        TODO()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return TODO()
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    TODO()
}