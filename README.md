### Clarke & Wrights

<p>The Clarke & Wright Savings algorithm is one of the heuristic studies in PRVC being based on the principle of resource savings (Clarke and Wright, 1964). The idea is that at each step of the algorithm the constraint factors are considered. The principle of the algorithm is based on the idea that if there are two different routes r = (0,..., i, 0) and s = (0, j,..., 0) that are feasible of a merge on a new route t = (0,..., i, j,... 0), the fusion of these routes generates a Cost Savings Sij, defined by: Sij = C(0, i) + C(0,j) - C(i,j) (OLIVEIRA and DELGADO, 2015). Therefore, the junction of paths is feasible when the sum of one or more routes do not exceed the vehicle capacity anymore. Q being the maximum load of each car. </p>

### Requirements

- Java 11 or higher
- Tell where the file is located for processing, such as an argument

### How to get this project

```shell
# Clone this repository
$ git clone <https://github.com/franklaercio/clarke-wrigths.git>

# Go to the directory
$ cd clarke-wrigths
```
