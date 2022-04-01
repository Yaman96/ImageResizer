import java.io.File;
import java.util.Objects;

public class Main {

    private static final int newWidth = 300;
    private static final int availableProcessors = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "/home/yaman/Рабочий стол/src";   //Source folder
        String dstFolder = "/home/yaman/Рабочий стол/dst";   //Destination folder

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int tempArrayLength = Objects.requireNonNull(files).length / availableProcessors;

        File[] tempArray = new File[tempArrayLength];
        int increment = 0;

        for(File file : files) {
            tempArray[increment++] = file;
            if(increment == tempArrayLength) {
                new imgResizer(tempArray,newWidth,dstFolder,System.currentTimeMillis()).start();
                tempArray = new File[tempArrayLength];
                increment = 0;
            }
        }
    }
}
