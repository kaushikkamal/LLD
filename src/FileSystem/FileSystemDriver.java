package FileSystem;

public class FileSystemDriver {
    public static void execute() {
        Directory documentsDirectory = new Directory("Documents");

        FileSystem file = new File("readme.txt");

        Directory aadharDirectory = new Directory("Aadhar");

        FileSystem f = new File("aadhar.txt");
        Directory aadharFrontDirectory = new Directory("Aadhar Front");
        Directory aadharBackDirectory = new Directory("Aadhar Back");
        FileSystem aadharFile = new File("aadhar.png");
        FileSystem aadharFilePDF = new File("aadhar.pdf");
        aadharFrontDirectory.add(aadharFile);
        aadharFrontDirectory.add(aadharFile);
        aadharBackDirectory.add(aadharFilePDF);

        aadharDirectory.add(f);
        aadharDirectory.add(aadharFrontDirectory);
        aadharDirectory.add(aadharBackDirectory);

        Directory panDirectory = new Directory("PAN");
        FileSystem panFile = new File("pan.png");
        panDirectory.add(panFile);

        documentsDirectory.add(file);
        documentsDirectory.add(aadharDirectory);
        documentsDirectory.add(panDirectory);

        documentsDirectory.ls(0);
    }
}
