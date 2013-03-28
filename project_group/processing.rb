require "csv"                              # require the CSV library

groups = Hash.new{|h, k| h[k] = []}

CSV.foreach("./input.csv", col_sep: "\t") do |row|   # open your file and loop 
  group_number = row[2]
  first_name = row[0]
  last_name = row[1]

  groups[group_number] << "#{first_name} #{last_name}"
end

text_content = ""
groups.each do |group_number, group_members|
  text_content << "Group: #{group_number} (#{group_members.size} members)\n"
  group_members.each do |member|
    text_content << "#{member}\n"
  end

  text_content << "\n"
end

puts text_content
File.open("./student_groups.txt", 'w') { |file| file.write(text_content) }

