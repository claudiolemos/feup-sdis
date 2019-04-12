package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

import utils.Utils;

public class Data implements Serializable{

  private String id;
  private int replicationDegree;
  private File file;
  private ArrayList<Chunk> chunks = new ArrayList<>();

  public Data(String path, int replicationDegree){
    this.file = new File(path);
    this.replicationDegree = replicationDegree;
    this.id = Utils.sha256(this.file.getName() + ':' + this.file.lastModified() + ':' + connection.Peer.getID());
    createChunks();
  }

  private void createChunks(){
    byte[] buffer = new byte[64000];

    try{
    FileInputStream fileStream = new FileInputStream(file);
    BufferedInputStream bufferedStream = new BufferedInputStream(fileStream);

    int size, chunkNumber = 1;
    while((size = bufferedStream.read(buffer)) != -1)
      chunks.add(new Chunk(id, chunkNumber++, Arrays.copyOf(buffer, size), size, replicationDegree));

    if(file.length() % 64000 == 0)
      chunks.add(new Chunk(id, chunkNumber++, null, 0, replicationDegree));
    }
    catch (IOException e) {
      System.err.println(e.toString());
      e.printStackTrace();
    }
  }

  public ArrayList<Chunk> getChunks(){
    return chunks;
  }

  public String getID(){
    return id;
  }

  public String getPath(){
    return file.getPath();
  }

  public int getReplicationDegree(){
    return replicationDegree;
  }

}
