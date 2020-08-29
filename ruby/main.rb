require './heheservice'

# module에서 자동으로 찾는다
module Friendboard
    class HohoService
      def initialize
      end
    
      def call
        instance = HeheService.new 'abcdef'
        instance.test_service
        test_service_func
      end  
    end
end

a = Friendboard::HohoService.new
a.call


# include moudle
# The include method is the way to “inject” code from one module into other modules or classes
#  extend allows you to add them as a class methods.
# `require` reads and parses files only once, when they were referenced for the first time. memory loading
# `load` reads and parses files every time you call `load`.
# Basically, module_function is a way of using module methods without mix-in the module into a class.
