require 'uri'
require 'net/http'

puts Net::HTTP.get(URI.parse("http://www.chula.ac.th"))
puts Net::HTTP.get_response(URI.parse("http://www.ise.eng.chula.ac.th"))


