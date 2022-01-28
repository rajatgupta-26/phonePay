You have to design and implement a Vehicle Rental Service which allows users to rent a given type of Vehicle for a given time slot.
Requirements:

    This Vehicle Rental Service will be operational only in one city (Delhi) which will have multiple branches (eg. Vasant Vihar Branch, CP branch, etc).
    Each branch can have three different types of vehicles (VehicleType) : Sedan, Hatchback, SUV. There could be any number of vehicles of each type in a branch.
    The rental price per hour should be defined at “per branch per vehicle type” level and NOT at an individual vehicle level. (eg. Sedan in CP branch = 150 rs/hr, Sedan in Vasant Vihar = 100 rs/hr, Hatchback in CP = 80rs/hr and so on)
    A user can request to rent a particular vehicle type for a given time slot. You will have to allot the vehicle from one of the branches if available for the given time slot with the “lowest rental price” strategy.

The following APIs have to be implemented:
Note: The given parameters are the mandatory parameters, you are free to add more parameters as part of your apis if you feel the need to do so. The return type of each api is up to you but make sure it provides the relevant information needed.

    addBranch(branchName)
    This will add a new branch for your Service.

    allocatePrice(branchName, vehicleType, price);
    This will be used to define price per vehicle type per branch

    addVehicle(vehicleId, vehicleType, branchName);
    This will add a new vehicle of the given vehicle type in a given existing branch.

    bookVehicle(vehicleType, startTime, endTime)
    This will be used to rent a vehicle for the given vehicle type for a given time slot defined by Start time and end time. You can expect the start time and endTime to be in hourly slots only.

    [Optional]viewVehicleInventory(startTime, endTime): This will give a snapshot of the inventory for the given time slot i.e. all the vehicles that are available and all the vehicles that are not available categorised by vehicleType.

Guidelines:

    You should store the data in-memory using a language-specific data-structure.
    You can print the output in console.
    Design your application in a way that a new rental Strategy can be implemented and used instead of the default one (lowest price).
    Implement clear separation between your data layers and service layers.
    You can take the startTime and endTime as DateTime or in any other way as you prefer.
    The start time and end time will be in hourly granularity only.

Expectations:

    Your code should cover all the mandatory functionalities explained above.
    Your code should be executable and clean.
    Your code should be properly refactored, and exceptions should be gracefully handled.
