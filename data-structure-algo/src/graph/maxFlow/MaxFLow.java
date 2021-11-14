package graph.maxFlow;

/**
 * 
 * flow from source to sink
 * 
 * SOURCE (s) - POSITIVE DIVERGEN
 * SINK (t) - NEGATIVE DIVERGEN
 * 
 * EDGE IS ROAD
 * 
 * EDGE WITH 2 VALUE - FLOW(SPEED) AND CAPACITY (VOLUMN)
 * CAPACITY IS UPPER BOUND 
 * 
 * CAPACITY OF EDGE
 * FLOW VALUE FOR EXAMPLE 10 LITER WATER PER SECOND
 * 
 * FLOW/CAPACITY => flow can never be greater than capacity
 * @author dheerajkumar02
 *
 */

/**
 * 
 * 1. capacity constraint => flow can not be great than capacity
 * 2. FLow conservation => the flow incoming must be equals to flow out going
 * 3. skew symmetry => f(u, v) = -f(v, u)
 * 4. Flow constraint => flow leaving s(source) must be equals to flow coming to t (sink)
 *
 */
public class MaxFLow {

}
