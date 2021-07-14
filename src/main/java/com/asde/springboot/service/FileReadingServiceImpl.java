package com.asde.springboot.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asde.springboot.entities.HospitalBedsData;

@Service
public class FileReadingServiceImpl implements IFileReadingService {
	
	private static final String fileName = "hospitalbeds.csv";
	private List<HospitalBedsData> list;
	
     FileReadingServiceImpl() throws IOException{
    	 Path path = Paths.get(fileName);
         List<String> allLines = Files.readAllLines(path);
         
         this.list = new ArrayList<HospitalBedsData>();
         
         for(int i=1;i<allLines.size();i++) {
        	 String words[] = allLines.get(i).split(",");
        	 HospitalBedsData data = new HospitalBedsData();
        	 for(int j=0;j<words.length;j++) {
        		 data.setBedType(words[0]);
        		 data.setLocation(words[1]);
        		 data.setAvailable(Boolean.parseBoolean(words[2]));
        		 data.setSlots(Integer.parseInt(words[3]));
        		 
     //   		 System.out.println(data.toString());
        		 list.add(data);
        	 }
        	 
         }         
     }

//    public static void main(String[] args) throws IOException {
//    	//FileReadingServiceImpl impl = new FileReadingServiceImpl();s
//    	
//    	 Path path = Paths.get(fileName);
//         List<String> allLines = Files.readAllLines(path);
//         
//         for(int i=1;i<allLines.size();i++) {
//        	 String words[] = allLines.get(i).split(",");
//        	 HospitalBedsData data = new HospitalBedsData();
//        	 for(int j=0;j<words.length;j++) {
//        		 data.setBedType(words[0]);
//        		 data.setLocation(words[1]);
//        		 data.setAvailable(Boolean.parseBoolean(words[2]));
//        		 data.setSlots(Integer.parseInt(words[3]));
//        		 
//        		 System.out.println(data.toString());
//        	 }
//        	 System.out.println("*********************************88");
//        	 
//         }
//         
//         //System.out.println("hello");
//    }
	/**
	 * TODO: Based on the filename passed to the constructor, the method needs to be implemented
	 * to get the no of slots available for the specified location and bedtype combination
	 * e.g. the rsult shall be 50 for icu and gurugram
	 */
	
	@Override
	public Integer getTotalBedsForLocation(String location, String bedType) {
		for(HospitalBedsData data : list) {
			if(data.getLocation().equalsIgnoreCase(location) && data.getBedType().equalsIgnoreCase(bedType))
				return data.getSlots();
		}
		return -1;
	}


	@Override
	public List<HospitalBedsData> readBedsData(String location) {
		List<HospitalBedsData> myList = new ArrayList<HospitalBedsData>();
		
		for(HospitalBedsData data : list) {
			if(data.getLocation().equalsIgnoreCase(location))
				myList.add(data);
		}
		return myList;
	}

	@Override
	public List<HospitalBedsData> readAllBedsData() {
		List<HospitalBedsData> myList = new ArrayList<HospitalBedsData>();
		
		for(HospitalBedsData data : list) {
			if(data.getAvailable().equals(true))
				myList.add(data);
		}
		return myList;
	}

}
