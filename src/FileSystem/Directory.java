package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String directoryName;

    List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls(int spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        System.out.println(sb.toString() + directoryName + "/");
        for (FileSystem each : fileSystemList) {
            each.ls(spaces + 4);
        }
    }
}
