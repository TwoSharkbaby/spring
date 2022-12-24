package org.zerock.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;

	private final PasswordEncoder passwordEncoder;

	@Transactional
	public int singup(MemberVO vo) {
		if (vo.getUserid() != null && vo.getUserid() != "" && vo.getUserid() != memberMapper.findById(vo.getUserid())) {
			try {
				log.info(vo.getUserid());
				log.info(memberMapper.findById(vo.getUserid()));
				String pass = passwordEncoder.encode(vo.getUserpw());
				vo.setUserpw(pass);
				AuthVO auth = new AuthVO();
				auth.setUserid(vo.getUserid());
				auth.setAuth("ROLE_USER");
				memberMapper.insert(vo);
				memberMapper.insertAuth(auth);
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				log.info("중복된 아이디 값입니다");
			}
		}
		return 1;
	}

}
