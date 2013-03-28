class Duck 
  def perform_fly
    fly()
  end
  def perform_quack
    quack()
  end
  def swim
    "All ducks float, even decoys!"
  end
end

module FlyWithWings 
  def fly
    "I'm flying!"
  end
end
module FlyNoWay 
  def fly
    "I can't fly."
  end
end
module Quack 
  def quack
    "Quack"
  end
end
module MuteQuack 
  def quack
    "Mute!"
  end
end


class MallardDuck < Duck
  include FlyWithWings
  include MuteQuack

  def display
    "I'm a real Mallard Duck"
  end
end

md = MallardDuck.new
puts md.perform_fly
puts md.perform_quack
