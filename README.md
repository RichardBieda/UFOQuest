This is my implementation of the codeGym module 3 final project.

A webapp with a model that provides a graph object (simple a set of arrays).
Servlets as contoller and jsp files for the view.
The class AppGraph sets a graph object to ServletContext. So that it can be called from jsp files

When start is clicked.
The StartServlet sets a (int) "level" session attribute. Each time the StartServlet is called anew, the level attribut is set to 0.
The level variable counts through the questions like a iterator. 
Then the quest.jsp will be the respond.

In the quest.jsp 
The methode graph.getQuestion(int level) shows the question, its parameter is the session level attribute.
A jstl each loop iterates through the answer options by using the result of the graph.getOptions(int level) call.
Then it shows the options as radio buttons. When the submit button will be pressed a post request hands on the result of the option as a int to the Answerservlet.

The AnswerServlet checks the correctness of the answer by calling the graph.isAnswerRight(level, option) method.
if the answer was correct and there is no more question left, the game is won. The finish jsp will be responded.
if the answer is correct and there is a question left, then the level variable will be increased by 1 and the the quest.jsp file will be responded anew.
if the answer was wrong then the finish.jsp will be responded.


I hope this explanation will help you a bit.

