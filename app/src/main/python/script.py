import pickle
import pandas as pd


def recommend_recipe_general(model, tfidf_vectorizer, data, input_ingredients):
    input_tfidf = tfidf_vectorizer.transform([' '.join(input_ingredients)])
    _, indices = model.kneighbors(input_tfidf)
    recommendations = data.iloc[indices[0]]['Name'].tolist()
    return recommendations

def process_entry(entry):
    # Use regular expression to extract text between double quotes
    ingredients = re.findall(r'"([^"]*)"', entry)
    return ingredients

df1 = pd.read_csv('app/src/main/assets/data.csv')
df1['Ingredients'] = df1['RecipeIngredientParts'].apply(process_entry)
df1 = df1[['Name', 'Ingredients']]

tfidf = TfidfVectorizer()
ingredients_str = df1['Ingredients'].apply(lambda x: ' '.join(x))
tfidf_matrix = tfidf.fit_transform(ingredients_str)
knn_model = NearestNeighbors(n_neighbors=3, algorithm='brute', metric='cosine')
knn_model.fit(tfidf_matrix)



def recipe_recom(input_ingredients):
    with open("app/src/main/assets/knn_model.pkl", "rb") as file:
        model = pickle.load(file)
    with open("app/src/main/assets/tfidf_vectorizer.pkl", "rb") as file:
        vec = pickle.load(file)

    data = pd.read_csv('app/src/main/assets/data.csv')
    recipe = recommend_recipe_general(model, vec, data, input_ingredients)

    return recipe
