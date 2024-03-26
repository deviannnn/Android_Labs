package com.example.lab09.exercise01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileHelper {
  private static final String TAG = "Image";
  private static final int IO_BUFFER_SIZE = 4 * 1024;
  public static Bitmap loadBitmap(String url) {
    Bitmap bitmap = null;
    InputStream in = null;
    BufferedOutputStream out = null;

    try {
      in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);

      final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
      out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
      copy(in, out);
      out.flush();

      final byte[] data = dataStream.toByteArray();
      BitmapFactory.Options options = new BitmapFactory.Options();
      //options.inSampleSize = 1;

      bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
    } catch (IOException e) {
      Log.e(TAG, "Could not load Bitmap from: " + url);
    } finally {
      closeStream(in);
      closeStream(out);
    }

    return bitmap;
  }
  private static void closeStream(Closeable stream) {
    if (stream != null) {
      try {
        stream.close();
      } catch (IOException e) {
        Log.e(TAG, "Could not close stream", e);
      }
    }
  }

  public static void copy(InputStream in, OutputStream out) throws IOException {
    byte[] b = new byte[IO_BUFFER_SIZE];
    int read;
    while ((read = in.read(b)) != -1) {
      out.write(b, 0, read);
    }
  }

  public static boolean isExternalStorageReadOnly() {
    String extStorageState = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
      return true;
    }
    return false;
  }

  public static boolean isExternalStorageAvailable() {
    String extStorageState = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
      return true;
    }
    return false;
  }
}
