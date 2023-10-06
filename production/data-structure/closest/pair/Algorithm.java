package closest.pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
   private List<Point> points;

   public Algorithm(List<Point> points) {
      this.points = points;
   }

   public double solveProblem() {
      List<Point> sortedXPoints = new ArrayList();
      List<Point> yPoints = new ArrayList();
      Iterator var3 = this.points.iterator();

      while(var3.hasNext()) {
         Point point = (Point)var3.next();
         sortedXPoints.add(point);
         yPoints.add(point);
      }

      this.sortByX(sortedXPoints);
      return this.findClosestPoints(sortedXPoints, yPoints, sortedXPoints.size());
   }

   public double findClosestPoints(List<Point> pointsSortedX, List<Point> pointsY, int numOfPoints) {
      if (numOfPoints <= 3) {
         return this.bruteForceApproach(pointsSortedX);
      } else {
         int middleIndex = numOfPoints / 2;
         Point middlePoint = (Point)pointsSortedX.get(middleIndex);
         List<Point> leftSubPointsY = new ArrayList();
         List<Point> leftSubPointsSortedX = new ArrayList();
         List<Point> rightSubPointsY = new ArrayList();
         List<Point> rightSubPointsSortedX = new ArrayList();

         for(int index = 0; index < numOfPoints; ++index) {
            if (((Point)pointsY.get(index)).getX() <= middlePoint.getX()) {
               leftSubPointsY.add(pointsY.get(index));
               leftSubPointsSortedX.add(pointsSortedX.get(index));
            } else {
               rightSubPointsY.add(pointsY.get(index));
               rightSubPointsSortedX.add(pointsSortedX.get(index));
            }
         }

         double sigmaLeft = this.findClosestPoints(leftSubPointsSortedX, leftSubPointsY, middleIndex);
         double sigmaRight = this.findClosestPoints(rightSubPointsSortedX, rightSubPointsY, numOfPoints - middleIndex);
         double sigma = Math.min(sigmaLeft, sigmaRight);
         List<Point> pointsInStrip = new ArrayList();

         for(int index = 0; index < numOfPoints; ++index) {
            if (Math.abs(((Point)pointsY.get(index)).getX() - middlePoint.getX()) < sigma) {
               pointsInStrip.add(pointsY.get(index));
            }
         }

         double minDistanceStrip = this.findMinimumDistanceInStrip(pointsInStrip, sigma);
         return Math.min(sigma, minDistanceStrip);
      }
   }

   public double bruteForceApproach(List<Point> points) {
      double minDistance = Double.MAX_VALUE;

      for(int i = 0; i < points.size(); ++i) {
         for(int j = i + 1; j < points.size(); ++j) {
            if (this.distance((Point)points.get(i), (Point)points.get(j)) < minDistance) {
               minDistance = this.distance((Point)points.get(i), (Point)points.get(j));
            }
         }
      }

      return minDistance;
   }

   private double findMinimumDistanceInStrip(List<Point> pointsInStrip, double sigma) {
      double minDistance = sigma;

      for(int i = 0; i < pointsInStrip.size(); ++i) {
         for(int j = i + 1; j < pointsInStrip.size() && ((Point)pointsInStrip.get(j)).getY() - ((Point)pointsInStrip.get(i)).getY() < minDistance; ++j) {
            if (this.distance((Point)pointsInStrip.get(i), (Point)pointsInStrip.get(j)) < minDistance) {
               minDistance = this.distance((Point)pointsInStrip.get(i), (Point)pointsInStrip.get(j));
            }
         }
      }

      return minDistance;
   }

   private void sortByX(List<Point> points) {
      Collections.sort(points, (point, otherPoint) -> {
         return Double.compare(point.getX(), otherPoint.getX());
      });
   }

   private double distance(Point point1, Point point2) {
      double xDistance = Math.abs(point1.getX() - point2.getX());
      double yDistance = Math.abs(point1.getY() - point2.getY());
      return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
   }

   public static void main(String[] args) {
      List<Point> points = Arrays.asList(new Point(1.0, 1.1), new Point(1.0, 2.0), new Point(2.0, 1.0), new Point(2.0, 2.0), new Point(2.0, 3.0), new Point(3.0, 3.0));
      Algorithm algorithm = new Algorithm(points);
      System.out.println(algorithm.solveProblem());
   }
}
