employees = [...]

managers = employees.select do |e|
  e.manager?
end


