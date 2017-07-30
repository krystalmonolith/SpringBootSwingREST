# SwingBootSwingREST
Basic Spring Boot application that puts up a trivial J2SE Swing interface, and also services REST GET/PUT endpoints for the Swing app's prompt JLabel and JTextField.

 ## REST Endpoints
 - GET Text from JTextField: http://127.0.0.1:8080/gui/text
 - PUT Text into JTextField: http://127.0.0.1:8080/gui/text/{text}
 - GET Prompt from JLabel: http://127.0.0.1:8080/gui/prompt
 - PUT Prompt into JLabel: http://127.0.0.1:8080/gui/prompt/{prompt}
