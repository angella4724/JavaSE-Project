package mylab.book.control;

import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

	
	
//	public Map<String, Double> calculateAveragePriceByType(Publication[] publications){
//
//	}
//
//	public Map<String, Double> calculatePublicationDistribution(Publication[] publications){
//		
//	}
//	
//	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
//		
//	}
	
	private String getPublicationType(Publication pub) {
		 if (pub instanceof Novel) {
	            return "소설";
	        } else if (pub instanceof Magazine) {
	            return "잡지";
	        } else if (pub instanceof ReferenceBook) {
	            return "참고서";
	        } else {
	        return "기타";
	        }
	}
	
	public void printStatistics(Publication[] publications) {
		
	}



	
	

}
