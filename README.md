# Module 2

## Reflection

1. The issue I fixed during the exercise was the redundant `public` keyword in the methods of an interface. To resolve this, I simply deleted the `public` keyword from those methods.
2. Yes, I think the current implementation has met the definition of Continuous Integration and Continuous Deployment. For CI, I have implemented github actions to automatically run the unit test suite. I have also implemented scorecard and pmd for code scanning/analysis whenever a push is made to the repository. For CD, I have set up the deployment of the application using Koyeb. Koyeb will detect every push made to the main branch and automatically triggers the build and deployment process.

# Module 1

## Reflection 1

After implementing these features, I learned that having a good naming convention for files, such as ProductController and ProductRepository, makes it easier to work on the project. I also learned to apply secure coding practices, like using POST requests exclusively for write operations (create, edit, delete).

## Reflection 2

1. After writing unit tests, I feel more confident that my code will run correctly. The number of unit tests depends on the complexity of the class. In order to make sure our unit tests are enough, we can use code coverage tools to check the test coverage. 100% code coverage does not necessarily mean our code has no errors. It means that all lines are executed. 
2. Duplicating setup procedures and instance variables may lead to redundant code, which can reduce maintainability. This approach can lead to potential clean code issues, such as code duplication, low maintainability, and reduced reliability. Some possible improvements are extracting common setup logic into a base test class, using parameterized tests for similar test cases, and organizing reusable methods in a utility/helper class.