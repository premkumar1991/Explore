# Functional requirement
    Elevator can move vertically up and down with some algorithm
    Elevator can have constraints on max capacity, speed
    Elevator should have internal request, person inside presses button for the destination floor, open door or close door
    Elevator should have external request for the up or down direction
    No starvation to any person waiting for an elevator
    Elevator Algorithm should be configurable
    Elevator should pick up the request, open the door  and serve the respective request waiting in the floor
    Elevator should close the door for after all person leaving the floor.
    Elevator should have emergency/alarm mechanisms on fail over inside it
# Extended Requirement
    Group of Elevators on the building/ blocks can be controlled by one coordinator which proxies the request to the respective elevator based on some Coordination Algorithm by analysis the each elevator parameters.

# 4 states of elevator
    elevator is in idle state
    elevator has request waiting in ongoing direction and wants to go in same direction
    elevator has request waiting in ongoing direction and wants to go in opposite direction
    elevator has request waiting in opposite direction of the ongoing direction

# Some of the algorithm's
    first come first serve
        
    shortest seek time first
        serve closest distance from current elevator position
        cons
            person far away from the elevator position will be starved if elevator has more closest request 
    scan
        has up wise and down wise boolean array or some state array
        lift will go up and check the floor request has set, if it set open door and serves the passenger and close the door
        once it reached the top and turns it direction to down, and follows the same process until bottom floor reach
        cons
            lift is moving unnecessarily to the idle request floor
    look ahead 
        in this approach, it scans forward on current direction and if any value is set, then it moves, else moves in opposite direction



