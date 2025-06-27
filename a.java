package a;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

public class a {
    private static final String input = "Data/dataset.csv";
    private static final int NEIGHBORHOOD_SIZE = 5;

    private static final String[] books = {
        "The F Word", "Davids Rache.", "Sky Knife", "The Groves of Academe", 
        "Karen's Lucky Penny", "Game Of Chance", "The Teaching of Reverence for Life", 
        "Finn's Twins!", "Mackenzie's Mountain", "And the Fans Roared"
    };

    private static final String[] usernames = {
        "booklover01", "page_turner", "reader_girl", "fiction_fan", 
        "novel_addict", "bookworm42", "lit_lover", "mystery_maniac", 
        "fantasy_fox", "shelf_surfer"
    };

    public static void main(String[] args) throws IOException, TasteException {
        BasicConfigurator.configure();

        DataModel model = new FileDataModel(new File(input));
        LogLikelihoodSimilarity similarity = new LogLikelihoodSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(NEIGHBORHOOD_SIZE, similarity, model);
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        int userId = 1;
        List<RecommendedItem> recommendations = recommender.recommend(userId, 6);

        System.out.println("Recommendations for customer: " + usernames[userId - 1]);
        System.out.println("************************************************************");
        System.out.printf("%-10s %-40s %-20s%n", "Book ID", "Title", "Estimated Preference");

        for (RecommendedItem recommendation : recommendations) {
            int bookId = (int) recommendation.getItemID();
            float estimatedPref = recommender.estimatePreference(userId, bookId);
            int index = bookId - 101;

            String bookTitle = (index >= 0 && index < books.length) ? books[index] : "Unknown Book";
            System.out.printf("%-10d %-40s %-20.2f%n", bookId, bookTitle, estimatedPref);
        }
    }
}
