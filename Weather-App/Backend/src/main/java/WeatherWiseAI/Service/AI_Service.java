package WeatherWiseAI.Service;
import org.springframework.beans.factory.annotation.Value;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import WeatherWiseAI.Entity.Weather_Data;



@org.springframework.stereotype.Service

public class AI_Service implements AI_Service_Methods{
	
	private GenerateContentResponse response ;
	private Client client  ;
	String aiModel = "gemini-2.5-flash" ;
	
	public AI_Service (@Value("${GEMINI_API_KEY}") String apikey) {
		this.client = Client.builder().apiKey(apikey).build();
		
	}

	@Override
	public String genAI(Weather_Data w) {
		String prompt = """
				Summarize the current weather conditions in a simple and engaging way for a general audience using the following data:
				Location : %s , State : %s , Country : %s , Local Time : %s , Temperature : %s , Feels Like : %s , Condition : %s ,
				Humidity : %s , Wind Speed :  %s , Wind Direction : %s Dont give the short names for wind direction
				The summary should be conversational and brief, as if it's a radio or app weather update. Avoid repeating data — combine them meaningfully. Keep it under 100 words.
				""".formatted(w.getName() , w.getState() , w.getCountry() , w.getTime() , w.getTemp() , w.getFeeltemp() , w.getText() , w.getHumidity() 
						, w.getWindSpeed() , w.getWindDir()
					) ;
		
			try {
			
		 response =client.models.generateContent(aiModel,prompt,null);
		
		
			return response.text() ; }
			
			catch (Exception e) {
//				e.printStackTrace();
				return "Something went wrong !\n Try again ! " ; 
			}
	}

	@Override
	public String greetMe() {
		String prompt = "Greet a user as he is a first time visitor on a website name Weather Wise AI. Wrap in 50 words." ;
		try {
			response = client.models.generateContent(aiModel, prompt, null) ;
			return response.text() ;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "Something went wrong ! ";
	}
	}


