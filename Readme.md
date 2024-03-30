# Smart Recipe App: Learning your taste with Machine Learning


Struggling to decide what to cook? The smart recipe app is here to help! It suggests recipes based on the ingredients you already have at home, making meal planning a breeze. What makes this app unique? Think of it as your personal recipe assistant - which learn your taste preferences through quizzes and suggestions using Machine Learning, providing customized recommendations just for you.

No more kitchen headaches, just tasty meals made easy! :)

Write about kotlin

A quick glimpse of the app's basic functionality can be viewed here:




# 1. Git

I've been using Git since my university days, mostly as a portfolio to host my projects. The thing I love the most is how I can host on my projects on Github and access it via different machines or say have multiple people collaborate together (done so in past projects).

Even in this project, as I was using multiple IDE (IntelliJ, VSC, Android Studio) it was very seamless to make changes on one IDE and have it reflected and ready to use on another. Additionally, I got to learn about Github Actions through this project which was new to me.

**Issues Faced**

While working on this project, I faced 2 major hurdles which I rectified using git commands (sadly I forgot to take screenshots of the issues🥲🥲).

1. I accidentally committed the recipe dataset and since it was around 600 it was not pushing to Github. After several trials, I was able to solve it using (it basically removed the file from the staging area)

   `git checkout -- recipes.csv`

2. Another issue was when I made a pipeline using Github Actions, in that when I called `./gradlew build` command for the first time, it showed permission denied. After looking through some stackoverflow posts, I was able to solve it using

   `git update-index --chmod=+x gradlew`

   and then the usual process of add, commit and push.


# 2. UML

Honestly, UML and DDD was the toughest part in this entire project. At first, I was like what is this thing, why is it even required and the online resources were equally bad. It took me 2 weeks to finally understand the concepts and the crucial role it plays in a project.

If I were to define UML, I would say I see it as a tool to sketch out the blueprint or design of your project. It's like visualizing how everything should be structured and how it will appear on the user interface (sortof).

I made these three UML diagrams for this project
1. [Activity Diagram](UML/activity.png)
2. [Class Diagram](UML/class_diagram.jpg)
3. [Use Case Diagram](UML/use_case_diagram.png)


# 3. DDD

This part was surprisingly enjoyable for me; I had a lot of fun eventstorming new ideas and trying to cram every problem known to mankind onto the eventstorming board (pun intended). I learned so much about software architecture during this process, especially about things like ubiquitous language and how different domains are mapped in a context map.

DDD is like a way to organize the project based on the practical problems it's solving. It's like building your software around the actual concepts and language used in the problem domain, making the  code more aligned with the business needs.

DDD for the following project are:
1. [Event Storming_1](DDD/event_storming_1.png)
2. [Event Storming_2](DDD/event_storming_2.png)
3. [Core-Domain Chart](DDD/core%20domain.png)
4. [Context Mapping](DDD/mappings.jpg)

A glimpse into the behind-the-scenes of making these diagrams

# 4. Metrics