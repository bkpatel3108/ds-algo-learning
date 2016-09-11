Run following command to start this program
java AirportCheckInSimulationTest

You can test this program in 2 ways.
1. Quick Test 2. Manual Test
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Quick Test
Inputs for simulation are hard coded in program.
To choose this option, enter 1. 
It will perform simulation and generate report of  simulation.
------------------------------------------
Hard coded inputs in program are as following:
Simulation time -> 100
No of first class check in counters -> 2
No of coach check in counters -> 3
Avg first class passenger arrival rate -> 6
Avg coach passenger arrival rate -> 3
Avg first class passenger service time -> 10
Avg coach passenger service time -> 8
------------------------------------------
Output :
Enter a number: 
1 - For quick test 
2 - For manual test 
1
Do you want to see output for each time unit? (Debug Mode) 
Enter a number: 
1 - For yes 
2 - For no 
2

Total Passengers >> 48
Total First Class Passengers >> 18
Total Coach Passengers >> 30
Avg Waiting Time >> 1.4375
Avg CheckIn Time (Waiting Time + Service Time) >> 9.791666666666666
Max Waiting Time >> 8
Max CheckIn Time (Waiting Time + Service Time) >> 23
Avg Coach Waiting Time >> 0.9333333333333333
Avg Coach CheckIn Time (Waiting Time + Service Time) >> 8.866666666666667
Max Coach Waiting Time >> 6
Max Coach CheckIn Time (Waiting Time + Service Time) >> 17
Avg First Class Waiting Time >> 2.2777777777777777
Avg First Class CheckIn Time (Waiting Time + Service Time) >> 11.333333333333334
Max First Class Waiting Time >> 8
Max First Class CheckIn Time (Waiting Time + Service Time) >> 23
First Class CheckIn Counters - CheckIn Counter -1 Occupancy >> 92.23300970873787
First Class CheckIn Counters - CheckIn Counter -2 Occupancy >> 79.6116504854369
Coach CheckIn Counters - CheckIn Counter -1 Occupancy >> 85.43689320388349
Coach CheckIn Counters - CheckIn Counter -2 Occupancy >> 80.58252427184466
Coach CheckIn Counters - CheckIn Counter -3 Occupancy >> 51.45631067961165
Avg Queue Length >> 0.33495145631067963
Max Queue Length >> 3
Avg First Class Passenger Queue Length >> 0.39805825242718446
Max First Class Passenger Queue Length >> 2
Avg Coach Passenger Queue Length >> 0.27184466019417475
Max Coach Passenger Queue Length >> 3
Final Simulation Time >> 103
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

2. Manual Test
You can create your own simulation environment using command line input. To choose this option, enter 2.
Start entering all the information. 
It will ask for following information
simulation time, no of first class checkin counters,no of coach checkin counters, avg first class passenger arrival rate,
avg coach passenger arrival rate, avg first class passenger service time, avg coach passenger service time.
For Example : To configure simulation environment as above mentioned hard coded simulation environment, you need to enter 
following values.
------------------------------------------
Output :
Enter a number: 
1 - For quick test 
2 - For manual test 
2
Do you want to see output for each time unit? (Debug Mode) 
Enter a number: 
1 - For yes 
2 - For no 
2
Please enter simulation time
100
Please enter no of first class checkin counters
2
Please enter no of coach checkin counters
3
Please enter avg first class passenger arrival rate
6
Please enter avg coach passenger arrival rate
3
Please enter avg first class passenger service time
10
Please enter avg coach passenger service time
8


Total Passengers >> 43
Total First Class Passengers >> 9
Total Coach Passengers >> 34
Avg Waiting Time >> 1.9069767441860466
Avg CheckIn Time (Waiting Time + Service Time) >> 9.790697674418604
Max Waiting Time >> 9
Max CheckIn Time (Waiting Time + Service Time) >> 26
Avg Coach Waiting Time >> 1.4705882352941178
Avg Coach CheckIn Time (Waiting Time + Service Time) >> 9.029411764705882
Max Coach Waiting Time >> 9
Max Coach CheckIn Time (Waiting Time + Service Time) >> 23
Avg First Class Waiting Time >> 3.5555555555555554
Avg First Class CheckIn Time (Waiting Time + Service Time) >> 12.666666666666666
Max First Class Waiting Time >> 7
Max First Class CheckIn Time (Waiting Time + Service Time) >> 26
First Class CheckIn Counters - CheckIn Counter -1 Occupancy >> 68.96551724137932
First Class CheckIn Counters - CheckIn Counter -2 Occupancy >> 52.58620689655172
Coach CheckIn Counters - CheckIn Counter -1 Occupancy >> 69.82758620689656
Coach CheckIn Counters - CheckIn Counter -2 Occupancy >> 56.03448275862068
Coach CheckIn Counters - CheckIn Counter -3 Occupancy >> 44.827586206896555
Avg Queue Length >> 0.35344827586206895
Max Queue Length >> 6
Avg First Class Passenger Queue Length >> 0.27586206896551724
Max First Class Passenger Queue Length >> 3
Avg Coach Passenger Queue Length >> 0.43103448275862066
Max Coach Passenger Queue Length >> 6
Final Simulation Time >> 116
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

More Examples: (in debug mode)
Enter a number: 
1 - For quick test 
2 - For manual test 
2
Do you want to see output for each time unit? (Debug Mode) 
Enter a number: 
1 - For yes 
2 - For no 
1
Please enter simulation time
50
Please enter no of first class checkin counters
1
Please enter no of coach checkin counters
2
Please enter avg first class passenger arrival rate
7
Please enter avg coach passenger arrival rate
3
Please enter avg first class passenger service time
6
Please enter avg coach passenger service time
3

Time >>1 /Passenger Created/ id: 1 type: COACH serviceTime: 1
Time >>2 /Passenger Served/ id: 1 type: COACH serviceTime: 1 time waited: 0
Time >>3
Time >>4 /Passenger Created/ id: 2 type: FIRST_CLASS serviceTime: 6
Time >>5 /Passenger Created/ id: 3 type: COACH serviceTime: 4
Time >>6
Time >>7 /Passenger Created/ id: 4 type: COACH serviceTime: 1
Time >>8 /Passenger Served/ id: 4 type: COACH serviceTime: 1 time waited: 0
Time >>9 /Passenger Served/ id: 3 type: COACH serviceTime: 4 time waited: 0
Time >>10 /Passenger Created/ id: 5 type: COACH serviceTime: 3 /Passenger Served/ id: 2 type: FIRST_CLASS serviceTime: 6 time waited: 0
Time >>11
Time >>12 /Passenger Created/ id: 6 type: FIRST_CLASS serviceTime: 4 /Passenger Created/ id: 7 type: COACH serviceTime: 4
Time >>13 /Passenger Created/ id: 8 type: COACH serviceTime: 4 /Passenger Served/ id: 5 type: COACH serviceTime: 3 time waited: 0
Time >>14
Time >>15 /Passenger Created/ id: 9 type: COACH serviceTime: 3
Time >>16 /Passenger Served/ id: 7 type: COACH serviceTime: 4 time waited: 0 /Passenger Served/ id: 6 type: FIRST_CLASS serviceTime: 4 time waited: 0
Time >>17 /Passenger Created/ id: 10 type: COACH serviceTime: 1 /Passenger Served/ id: 8 type: COACH serviceTime: 4 time waited: 0
Time >>18 /Passenger Served/ id: 10 type: COACH serviceTime: 1 time waited: 0
Time >>19 /Passenger Created/ id: 11 type: COACH serviceTime: 3 /Passenger Served/ id: 9 type: COACH serviceTime: 3 time waited: 1
Time >>20 /Passenger Created/ id: 12 type: FIRST_CLASS serviceTime: 9 /Passenger Created/ id: 13 type: COACH serviceTime: 5
Time >>21
Time >>22 /Passenger Created/ id: 14 type: COACH serviceTime: 3 /Passenger Served/ id: 11 type: COACH serviceTime: 3 time waited: 0
Time >>23
Time >>24 /Passenger Created/ id: 15 type: COACH serviceTime: 4
Time >>25 /Passenger Served/ id: 14 type: COACH serviceTime: 3 time waited: 0 /Passenger Served/ id: 13 type: COACH serviceTime: 5 time waited: 0
Time >>26
Time >>27
Time >>28
Time >>29 /Passenger Served/ id: 15 type: COACH serviceTime: 4 time waited: 1 /Passenger Served/ id: 12 type: FIRST_CLASS serviceTime: 9 time waited: 0
Time >>30 /Passenger Created/ id: 16 type: COACH serviceTime: 3
Time >>31
Time >>32 /Passenger Created/ id: 17 type: COACH serviceTime: 4
Time >>33 /Passenger Served/ id: 16 type: COACH serviceTime: 3 time waited: 0
Time >>34 /Passenger Created/ id: 18 type: FIRST_CLASS serviceTime: 5
Time >>35
Time >>36 /Passenger Served/ id: 17 type: COACH serviceTime: 4 time waited: 0
Time >>37
Time >>38
Time >>39 /Passenger Served/ id: 18 type: FIRST_CLASS serviceTime: 5 time waited: 0
Time >>40 /Passenger Created/ id: 19 type: FIRST_CLASS serviceTime: 8
Time >>41
Time >>42 /Passenger Created/ id: 20 type: COACH serviceTime: 4
Time >>43
Time >>44
Time >>45
Time >>46 /Passenger Served/ id: 20 type: COACH serviceTime: 4 time waited: 0
Time >>47 /Passenger Created/ id: 21 type: COACH serviceTime: 2
Time >>48 /Passenger Served/ id: 19 type: FIRST_CLASS serviceTime: 8 time waited: 0
Time >>49 /Passenger Served/ id: 21 type: COACH serviceTime: 2 time waited: 0
Time >>50 /Passenger Created/ id: 22 type: FIRST_CLASS serviceTime: 3 /Passenger Created/ id: 23 type: COACH serviceTime: 5
Time >>51
Time >>52
Time >>53 /Passenger Served/ id: 22 type: FIRST_CLASS serviceTime: 3 time waited: 0
Time >>54
Time >>55 /Passenger Served/ id: 23 type: COACH serviceTime: 5 time waited: 0

Total Passengers >> 23
Total First Class Passengers >> 6
Total Coach Passengers >> 17
Avg Waiting Time >> 0.08695652173913043
Avg CheckIn Time (Waiting Time + Service Time) >> 3.9565217391304346
Max Waiting Time >> 1
Max CheckIn Time (Waiting Time + Service Time) >> 9
Avg Coach Waiting Time >> 0.11764705882352941
Avg Coach CheckIn Time (Waiting Time + Service Time) >> 3.2941176470588234
Max Coach Waiting Time >> 1
Max Coach CheckIn Time (Waiting Time + Service Time) >> 5
Avg First Class Waiting Time >> 0.0
Avg First Class CheckIn Time (Waiting Time + Service Time) >> 5.833333333333333
Max First Class Waiting Time >> 0
Max First Class CheckIn Time (Waiting Time + Service Time) >> 9
First Class CheckIn Counters - CheckIn Counter -1 Occupancy >> 63.63636363636363
Coach CheckIn Counters - CheckIn Counter -1 Occupancy >> 67.27272727272727
Coach CheckIn Counters - CheckIn Counter -2 Occupancy >> 30.909090909090907
Avg Queue Length >> 0.01818181818181818
Max Queue Length >> 1
Avg First Class Passenger Queue Length >> 0.0
Max First Class Passenger Queue Length >> 0
Avg Coach Passenger Queue Length >> 0.03636363636363636
Max Coach Passenger Queue Length >> 1
Final Simulation Time >> 55
