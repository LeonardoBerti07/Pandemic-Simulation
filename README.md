# Pandemic-Simulation
This is the simulation of a pandemic, it is not going to be a reliable or scientific simulation. 

There are 3 java class Project/src/Menù.java, Project/src/Mondo.java, Project/src/Malattia.java.


If you run it, a ui will appear where you can enter data to customize the simulation.


The data to be entered concern the virus (symptoms, infectivity, lethality and average duration for each person), the population, the average daily meetings for each person, the resources, the cost of the tampon and the strategy to be applied.


There are 6 possible strategies:

    1. Positive Quarantine -> All people who are swabbed and tested positive do a 14-day quarantine

    2. lockdown -> all people are locked in the house, when they are running out of resources it ends

    3. Spartan -> all people who test positive are killed

    4. seek cure low / medium / high -> are all left free and in the meantime resources are used to seek a cure


In the final screen the colors represent:

    -green -> people who have never caught the virus or who have it in incubation

    -yellow -> currently positive asymptomatic

    -red -> currently positive symptomatic

    -black -> dead

    -blue -> healed
