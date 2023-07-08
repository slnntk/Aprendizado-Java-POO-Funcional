package a.interfaces;

import a.entities.Item;

import java.util.List;
import java.util.Set;

public interface LeitorInterface {
    Set<Item> lerArchiveEmp(String path);
    Set<Item> lerArchiveMlg(String path);
}
