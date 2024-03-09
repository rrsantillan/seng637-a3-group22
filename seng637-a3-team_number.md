**SENG 637 - Dependability and Reliability of Software Systems**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for X and Y methods

Text…

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

We tried to test all of the different coverage tools described in the assignment instructions.
Here is a list of the coverage tools that we tested and some notes for each one:

### ECLEmma:
- Provides comprehensive coverage metrics.
- Shows instruction coverage, branch coverage, line coverage, method coverage, type coverage, and complexity coverage
- Intuitive interface for understanding coverage results
  
### JaCoCo:
- Has the same features as EclEmma and there seem to be no differences
  
### Clover:
- Offers advanced features for identifying project risks and complex cases
- Has a dashboard view and code highlighting
  - It also highlights the top project risks, most complex cases and least tested methods in the dashboard view
- Provides detailed insights into code coverage and complexity
  - This includes the average number of paths per method and cyclomatic complexity
- Requires additional effort to set up and configure properly
- There are compatibility issues with certain project setups and environments and it was difficult to get this tool to work consistently
  
### CodeCover:
- When setting this up, we ran into this error:

  `Plug-in "org.codecover.eclipse" was unable to instantiate class "org.codecover.eclipse.junit.JUnitLaunchConfigurationDelegate".org/eclipse/osgi/framework/internal/core/BundleHost`

- After looking into this, it seems like this tool only works on the Eclipse Kepler version of Eclipse and therefore we did not look into this further since none of us had Eclipse Kepler installed

### Cobertura:
- We were unable to set this up as it was difficult to understand
- It does not have a native eclipse plugin, an external download is required
- Documentation is sparse and hard to navigate with some broken links

### Coverlipse:
- Latest release was in 2009 so it is outdated and we weren’t able to make it work with our versions of eclipse
- It was last compatible with Eclipse version 3.4, we were using using Eclipse 2023-12 R

After going through the various coverage tools, we as a team, decided to use ECLEmma as it offered statement (instruction) coverage, branch coverage and a suitable alternative for condition coverage, which was method coverage. It was also the easiest to use and worked well on all of our systems.


# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
