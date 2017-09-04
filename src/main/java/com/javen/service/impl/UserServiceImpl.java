package com.javen.service.impl;
import java.util.List;

import javax.annotation.Resource;  
  





import org.springframework.stereotype.Service;  

import com.javen.dao.IUserDao;
import com.javen.dao.IUserDaoto;
import com.javen.model.User;
import com.javen.service.IUserService;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDaoto IUserDaoto;  
    
    public User getUserById(int userId) {
		return null;  
        // TODO Auto-generated method stub  
    }

	public List<User> selectByState(Integer state) {
		// TODO Auto-generated method stub  
		return IUserDaoto.selectByState(state);
	}

	@Override
	public List<User> selectByname(User user) {
		
		
		return IUserDaoto.selectByUsername(user);
	}

	@Override
	public int Insetuser(User user) {

		List<User> selectByname = selectByname(user);
		if(selectByname.size()>0)
		{
			return 0;
		}
		
		return IUserDaoto.Insetuser(user);
	}

	@Override
	public List<User> selectByemailUUid(User user) {
		// TODO Auto-generated method stub
		List<User> selectByemailUUid = IUserDaoto.selectByemailUUid(user);
		if(selectByemailUUid.size()==1)
		{
			updateuserinfoforemailUUid(user);
		}
		
		return selectByemailUUid;
	}

	@Override
	public int updateuserinfoforemailUUid(User user) {
		// TODO Auto-generated method stub
		
		return IUserDaoto.updateuserinfoforemailUUid(user);
	}

	@Override
	public List<User> selectUserpasswowrdcheck(User user) {
		// TODO Auto-generated method stub  
		return IUserDaoto.selectUserpasswowrdcheck(user.getUsername(),user.getPassword());
	}  
  
}  
