package br.com.rafaelshayashi.catalogue.config;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;

import java.util.*;

public class JWSBuilder {

    public static JsonWebSignature getToken(RsaJsonWebKey rsaJsonWebKey, String claimsIssuer, String claimsSubject) {

        JwtClaims claims = new JwtClaims();
        claims.setIssuer(claimsIssuer);
        claims.setSubject(claimsSubject);
        claims.setJwtId(UUID.randomUUID().toString());
        claims.setIssuer("http://localhost:9000/auth/realms/library-by-example");
        claims.setSubject("4cbde388-6dd0-41e0-a3e8-f000c9024f2f");
        claims.setAudience("https://host/api");
        claims.setExpirationTimeMinutesInTheFuture(10);
        claims.setIssuedAtToNow();
        claims.setClaim("azp", "front-library-client");
        claims.setClaim("scope", "openid profile email");
        claims.setClaim("realm_access", getRoles());

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        jws.setAlgorithmHeaderValue(rsaJsonWebKey.getAlgorithm());
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
        jws.setHeader("typ", "JWT");

        return jws;
    }

    private static Map<String, List<String>> getRoles() {
        Map<String, List<String>> roles =  new HashMap<>();
        List<String> rolesName = new ArrayList<>();
        rolesName.add("offline_access");
        rolesName.add("librarian");
        rolesName.add("uma_authorization");

        roles.put("roles", rolesName);
        return roles;
    }
}
