# AI-BASED-RECOMMENDATION-SYSTEM
Company:CODTECH IT SOLUTION

Name:Ashwin Pradeep Pai

Intern Id:CT04DG64

Domain:Java Programming

Duration:4 Week

Mentor:NEELA SANTOSH

Output:



![Image](https://github.com/user-attachments/assets/48ed64dd-f1b3-4ded-a6d0-3ffb6a7858c8)





![Image](https://github.com/user-attachments/assets/268a92d5-6002-4f9d-9fb7-09dfa7e8c472)





![Image](https://github.com/user-attachments/assets/676c19e2-32b4-44b9-ad07-f8231ebf8f25)



Description:This Java program is an implementation of an AI-based recommendation system using Apache Mahout, designed to suggest books to users based on collaborative filtering. The program uses a structured dataset stored in a file named dataset.csv, where each entry contains three essential components: userID, bookID, and review. The userID represents a unique user, the bookID corresponds to a specific book, and the review is a rating score given by the user to that book, generally on a scale from 1 to 5. The system leverages Mahout’s FileDataModel class to read and load this dataset, which forms the core input for generating personalized recommendations. Once the data is loaded, Mahout's LogLikelihoodSimilarity class computes the similarity between users based on their rating patterns. This similarity metric is effective in identifying users with common preferences and is particularly suited to sparse datasets. The NearestNUserNeighborhood class is used to build a set of the most similar users (neighborhood) for a given user, defined by a fixed number of neighbors (in this case, 5). With the neighborhood established, Mahout’s GenericUserBasedRecommender generates a list of recommended books for a target user, by analyzing the books liked by similar users but not yet rated by the target user. In this implementation, the system is configured to recommend books for the first user (userID = 1). To enhance readability and relevance, arrays of book titles and usernames are used to map the internal book IDs and user IDs to real-world names. As a result, the output displays personalized recommendations such as the book title, the corresponding book ID, and the estimated preference score for that user. The output is formatted using Java’s System.out.printf() method to align columns and ensure a clean, tabular structure that is easy to read and interpret. The dataset used (dataset.csv) is carefully prepared to avoid any duplicate (userID, bookID) entries, which helps maintain data consistency and avoids skewing similarity computations. The reviews in the dataset are distributed in such a way that multiple users rate a variety of books, ensuring enough overlap in ratings to build meaningful similarity relationships. This overlap is crucial for collaborative filtering systems to perform effectively, as recommendations rely on shared behavior among users. Although the dataset and mappings in this project are kept small for demonstration purposes, the architecture is scalable and capable of handling large datasets with thousands of users and books. The use of BasicConfigurator from the Log4j library enables minimal yet essential logging for Mahout’s internal processing. Overall, this project serves as a practical and educational example of building a recommender system using machine learning principles. It highlights the essential steps of data ingestion, similarity computation, neighborhood formation, and preference prediction in a collaborative filtering pipeline. By combining structured data (userID, bookID, review) with Apache Mahout’s recommendation framework, the system demonstrates how user behavior can be transformed into intelligent suggestions, providing a strong foundation for real-world applications in domains such as e-commerce, digital libraries, online learning platforms, and entertainment services.
