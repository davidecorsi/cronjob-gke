package it.partec.cronjob_gke;

import java.io.File;

public class App 
{
    public static void main( String[] args )
    {
    	String volumePath = System.getenv("VOLUME_PATH");
    	System.out.println("Directory=" + volumePath);
		File volumeDir = new File(volumePath);
		System.out.println("File cancellati:");
		if(volumeDir.exists() && volumeDir.isDirectory()) {
			String[] fileList = volumeDir.list();
			if(fileList != null) {
				for (String file : fileList) {
					System.out.println(file);
					File f = new File(volumePath + file);
					f.delete();
				}
			}
		}
    }
}
