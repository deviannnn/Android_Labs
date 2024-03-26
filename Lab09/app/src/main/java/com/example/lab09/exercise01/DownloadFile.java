package com.example.lab09.exercise01;

import android.graphics.Bitmap;
import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.Objects;

public class DownloadFile implements Serializable {

  private String name;
  private String size;
  private String status;
  private String downloadPath;
  private Bitmap imageThumBitmap;

  public DownloadFile() {
  }

  public DownloadFile(String name, String size, String status, String downloadPath) {
    this.name = name;
    this.size = size;
    this.status = status;
    this.downloadPath = downloadPath;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDownloadPath() {
    return downloadPath;
  }

  public void setDownloadPath(String downloadPath) {
    this.downloadPath = downloadPath;
  }

  public Bitmap getImageThumBitmap() {
    return imageThumBitmap;
  }

  public void setImageThumBitmap(Bitmap imageThumBitmap) {
    this.imageThumBitmap = imageThumBitmap;
  }

  @RequiresApi(api = VERSION_CODES.KITKAT)
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadFile that = (DownloadFile) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(size, that.size) &&
        Objects.equals(downloadPath, that.downloadPath);
  }

  @RequiresApi(api = VERSION_CODES.KITKAT)
  @Override
  public int hashCode() {
    return Objects.hash(name, size, downloadPath);
  }

  @Override
  public String toString() {
    return "DownloadFile{" +
        "name='" + name + '\'' +
        ", size='" + size + '\'' +
        ", downloadPath='" + downloadPath + '\'' +
        '}';
  }
}
