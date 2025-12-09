-- Datos iniciales para tablas users y authorities

select * from;

INSERT INTO users (username, password, enabled) VALUES
    ('admin', '{noop}to_be_encoded', true),
    ('user',  '{noop}to_be_encoded', true)
ON CONFLICT (username) DO NOTHING;

INSERT INTO authorities (username, authority) VALUES
    ('admin', 'ROLE_ADMIN'),
    ('user',  'ROLE_USER')
ON CONFLICT DO NOTHING;
