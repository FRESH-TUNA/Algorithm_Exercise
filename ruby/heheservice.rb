module Friendboard
    class HeheService 
      def initialize(hoho)
        @hoho = hoho 
      end
  
      def test_service
        print @hoho
      end
    end

    # 함수는 메모리에 로딩이 안된다.
    def self.def test_service_func
        print 'abcdefgh'
    end
end
