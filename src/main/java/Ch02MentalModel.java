import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

import static org.apache.spark.sql.functions.concat;
import static org.apache.spark.sql.functions.lit;
public class Ch02MentalModel {
    public static void main(String[] args){
        Ch02MentalModel chapt02 = new Ch02MentalModel();
        chapt02.start();
    }

    private void start()
    {
        //Create SparkSession
        SparkSession sparkSession = SparkSession.builder()
                .appName("Chapter02 Metal Model")
                .master("local")
                .getOrCreate();

        // Step 1 : Ingest Data
//        Dataset<Row> df = sparkSession.read()
//                .format("csv")
//                .option("header", "true")
//                .load("/home/wuuhoang/Java/Spark/src/main/java/authors.csv");
        Dataset<Row> df = sparkSession
                .read()
                .option("header", "true")
                .csv("/home/wuuhoang/Java/Spark/src/main/java/authors.csv");
        df.show();
        // Step 2: Transform data
        df = df.withColumn("fullName", concat(df.col("lname"), lit(" , "), df.col("fname")));


        // Step 3: Save to database
        Properties prop = new Properties();
        PostgreConn conn = new PostgreConn();
        prop.setProperty("driver", conn.getDriver());
        prop.setProperty("user", conn.getUser());
        prop.setProperty("password", conn.getPassword());


        // --> Write to the table customer
        df.write()
                .mode(SaveMode.Overwrite)
                .jdbc(conn.getConnUrl(), "customer", prop);

        System.out.println("Process Complete");

    }



}
