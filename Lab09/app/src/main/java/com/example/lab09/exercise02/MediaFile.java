package com.example.lab09.exercise02;

import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.Objects;

public class MediaFile implements Serializable {

  private String name;
  private String path;

  public MediaFile() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
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
    MediaFile mediaFile = (MediaFile) o;
    return Objects.equals(name, mediaFile.name) &&
        Objects.equals(path, mediaFile.path);
  }

  @RequiresApi(api = VERSION_CODES.KITKAT)
  @Override
  public int hashCode() {
    return Objects.hash(name, path);
  }

  @Override
  public String toString() {
    return "MediaFile{" +
        "name='" + name + '\'' +
        ", path='" + path + '\'' +
        '}';
  }
}
