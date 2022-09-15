public class HW1 {
    /**
     * @param coords        a 2 dimensional array of doubles - the first dimension is the number of particles, and the second dimension is size 3 (x,y,z)
     * @param velocities    a 2 dimensional array of doubles - the first dimension is the number of particles, and the second dimension is size 3 (x,y,z)
     * @param numParticles  an integer representing the number of particles in the coords and velocities arrays
     * @param timeStep      a double representing the amount of "virtual" time (in seconds) that will have passed
     */
    public void updatePositions(double[][] coords, double[][] velocities, int numParticles, double timeStep) {
        for (int index = 0; index < numParticles; index++) {
            if (coords[index][1] <= 0.0)
                continue;
            else {
                coords[index][0] = coords[index][0] + (velocities[index][0] / 2.0) * timeStep;
                coords[index][1] = coords[index][1] + (velocities[index][1] / 2.0) * timeStep;
                coords[index][2] = coords[index][2] + (velocities[index][2] / 2.0) * timeStep;
            }
            velocities[index][1] = velocities[index][1] - 9.8 * timeStep;
        }
    }
}

/*
 * Explanation                                                                              | (will be executed...)
 * ____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
 * Line 9  | for loop                                                                       | N times ---->-------------------->---------------multiply N by 16---------------------->------------------------> 16N ---------->\
 *         |                                                                                |                                                                                                                    ^              \---> 16N + (2N + 2) = 18N + 2
 * Line 9  | index = 0                                                                      | 1 due to initialization            \                                                                               |              /                       |
 * Line 9  | index < numParticles                                                           | N + 1 times number of comparisons   |---> 1 + N + 1 + N = 2N + 2 -------->---------------->--------------->--------------------->/                        |
 * Line 9  | index++                                                                        | N times of incrementing index      /                                                                               |                                      v
 *         |                                                                                |                                                                                                                    |                                 Result: O(N)
 * Line 10 | if (coords[index][1] <= 0.0)                                                   | 1 times                                                                  \---> 1      \                            ^
 * Line 11 | continue                                                                       | is not included because else block has heavier time complexity (12 > 2)  /             \      `                    |
 *         |                                                                                |                                                                                         |                          |
 * Line 13 | (velocities[index][0] / 2.0)                                                   | 1 due to division             \                                                         |                          |
 * Line 13 | (velocities[index][0] / 2.0) * timeStep                                        | 1 due to multiplication        |---> 1 + 1 + 1 + 1 = 4                                  |                          |
 * Line 13 | coords[index][0] + (velocities[index][0] / 2.0) * timeStep                     | 1 due to addition              |                                                        |                          ^
 * Line 13 | coords[index][0] = coords[index][0] + (velocities[index][0] / 2.0) * timeStep  | 1 due to value assignment     /                                                         |                          |
 *         |                                                                                |                                                                                         |                          |
 * Line 14 | (velocities[index][1] / 2.0)                                                   | 1 due to division             \                                                         |                          |
 * Line 14 | (velocities[index][1] / 2.0) * timeStep                                        | 1 due to multiplication        |---> 1 + 1 + 1 + 1 = 4                                  \                          |
 * Line 14 | coords[index][1] + (velocities[index][1] / 2.0) * timeStep                     | 1 due to addition              |                                                         |---> 1 + 4 + 4 + 4 + 3 = 16
 * Line 14 | coords[index][1] = coords[index][1] + (velocities[index][1] / 2.0) * timeStep  | 1 due to value assignment     /                                                         /
 *         |                                                                                |                                                                                        |
 * Line 15 | (velocities[index][2] / 2.0)                                                   | 1 due to division             \                                                        |
 * Line 15 | (velocities[index][2] / 2.0) * timeStep                                        | 1 due to multiplication        |---> 1 + 1 + 1 + 1 = 4                                 |
 * Line 15 | coords[index][2] + (velocities[index][2] / 2.0) * timeStep                     | 1 due to addition              |                                                       |
 * Line 15 | coords[index][2] = coords[index][2] + (velocities[index][2] / 2.0) * timeStep  | 1 due to value assignment     /                                                        |
 *         |                                                                                |                                                                                        |
 * Line 17 | 9.8 * timeStep                                                                 | 1 due to multiplication       \                                                        |
 * Line 17 | velocities[index][1] - 9.8 * timeStep                                          | 1 due to subtraction           |---> 1 + 1 + 1 = 3                                    /
 * Line 17 | velocities[index][1] = velocities[index][1] - 9.8 * timeStep                   | 1 due to value assignment     /                                                      /
 */
