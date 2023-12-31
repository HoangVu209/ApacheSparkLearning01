import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CsvToDataframe {

    public static void main(String [] args){

        CsvToDataframe app = new CsvToDataframe();
        app.start();
    }

    private void start()
    {
        // Creates a session on a local master
        SparkSession spark = SparkSession.builder()
                .appName("CSV to Dataset")
                .master("local")
                .getOrCreate();
        // Reads a CSV file with header, called books.csv, stores it in a
        // dataframe
        Dataset<Row> df = spark.read().format("csv")
                .option("header", "true")
                .load("/home/wuuhoang/Java/Spark/src/main/java/book.csv");
        // Shows at most 5 rows from the dataframe
        df.show(5);
    }
}
