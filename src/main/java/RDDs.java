import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDs {
    public static void main(String [] args){
/*          SparkConf conf = new SparkConf().setAppName("My Apache Spark").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        // C1: Create RDD by calling JavaSparkContext's parallelize on existing Collection
      List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(data);
        System.out.println("Sum: " + distData.reduce((a, b) -> a + b));*/

        // C2: Create RDD using external resources
        SparkConf conf1 = new SparkConf().setAppName("My Apache Spark01").setMaster("local");
        JavaSparkContext sc1 = new JavaSparkContext(conf1);
        sc1.setLogLevel("ERROR");
        JavaRDD<String> distFile =  sc1.textFile("/home/wuuhoang/Java/Spark/src/main/java/*.txt");
        distFile.collect().forEach(System.out::println);


        //SparkSession

    }
}
