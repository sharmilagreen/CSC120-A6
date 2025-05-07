Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?
What worked, what didn't, what advice would you give someone taking this course in the future?

Unit testing felt ok in practice, but I struggled with the concept a little as being useful. Maybe that is just because I tend to check my code as I build it and so I would be checking the unit tests themselves, which just adds more work to a project.

Implemented tests:
testEngineConstructor - tests engine constructor
testEngineGo - tests that go depletes fuel
testCarAddPassenger - tests that a car can add a passenger when has space and can't when it's full (wasn't really sure how else to do this)
testCarRemovePassenger - tests that you can't remove a passenger from a car they haven't boarded
testPassengerBoardCarWithSpace - tests that boarding a car results in depletion of seats remaining (wasn't sure how else to do this either)
testPassengerBoardCarFull - tests that seatsRemaining reports 0 when car is full
testTrainConstructor - tests train constructor
testTrainPassengerCount - tests seats remaining and maxcapacity
testTrainGetCar - tests expected car retrieved
testTrainPrintManifest - tests if names Helen and Ivy are on manifest after boarding