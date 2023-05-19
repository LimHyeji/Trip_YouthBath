package com.ssafy.enjoytrip.util.jwt;

import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.util.encrypt.Encrypt;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTProvider {
    private final Logger log =LoggerFactory.getLogger(JWTProvider.class);

    @Value("${jwt.secret_key}")
    private String SECRET_KEY;

    @Value("${jwt.exp}")
    private long exp;

    private final Encrypt encrypt;

    public JWTProvider(Encrypt encrypt){
        this.encrypt=encrypt;
    }

    public String createToken(MemberVO member) throws Exception {
        String token = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject("userToken")
                .setExpiration(new Date(System.currentTimeMillis()+exp))
                .claim("id",member.getId())
                .claim("name",member.getName())
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY.getBytes())
                .compact();
        System.out.println("token = " + token);
        return encrypt.encrypt(token);
    }

    public MemberVO parseInfo(String accessToken) throws JWTException {
        Jws<Claims> claims = null;
        try{
            accessToken = encrypt.decrypt(accessToken);
            MemberVO info = new MemberVO();
            claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(accessToken);
            info.setId(claims.getBody().get("id",String.class));
            info.setName(claims.getBody().get("name",String.class));
            return info;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            //만료시간 지남
            //jwt가 예상하는 형식과 다른 형식이거나 구성
            //잘못된 jwt구조
            //JWT의 서명실패(변조 데이터)
            throw new JwtException("다시 로그인 해주세요");
        } catch (Exception e) {
            throw new JwtException("다시 로그인 해주세요");
        }
    }

    public boolean isValidToken(String accessToken) throws JwtException {
        try{
            accessToken = encrypt.decrypt(accessToken);
            Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(accessToken);
            return true;
        }catch(SignatureException e){
            log.error("Invalid JWT Signature",e);
        }catch(MalformedJwtException e){
            log.error("Invalid JWT Token",e);
        }catch(ExpiredJwtException e){
            log.error("Expired JWT token",e);
        }catch(UnsupportedJwtException e){
            log.error("Unsupported JWT token",e);
        }catch(IllegalArgumentException e){
            log.error("JWT claims string is empty",e);
        } catch (Exception e) {
            throw new JwtException("다시 로그인 해주세요");
        }
        return false;
    }
}
