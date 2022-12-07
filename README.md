# Assignment 1 part 2 TDD

## Comments
### Game.subscribe, Game.unsubscribe
I would like to have tested that the methods call add and remove on the ArrayList of subscribers, however it does not seem to be possibe to mock parameterized types dynamically using the mockedConstruction function (i.e. I was not able to mock the ArrayList\<Subscriber\> object instantiated in the Game constructor).

