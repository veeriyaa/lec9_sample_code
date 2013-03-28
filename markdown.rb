require 'maruku'  
   
str = "#This is a title\n\n* some\n* list\n* items"  
md  = Maruku.new(str)  
puts md.to_html_document  
