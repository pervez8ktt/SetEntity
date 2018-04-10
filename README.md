# SetEntity

    
		
		FromClass fromClass = new FromClass();
		
		fromClass.setId(1);
		fromClass.setName("Pervez");
		fromClass.setDob(new Date());
		
		
		
		ToClass toClass = SetEntityByModel.setFields(fromClass, ToClass.class);
		
		
		System.out.println(toClass.getId());
		System.out.println(toClass.getName());
		System.out.println(toClass.getDob());
