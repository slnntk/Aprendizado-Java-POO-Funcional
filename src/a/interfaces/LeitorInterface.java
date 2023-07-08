package a.interfaces;

import a.entities.Item;

import java.util.List;

public interface LeitorInterface {

    List<Item> lerArchiveEmp(String path);
    List<Item> lerArchiveMlg(String path);

}
